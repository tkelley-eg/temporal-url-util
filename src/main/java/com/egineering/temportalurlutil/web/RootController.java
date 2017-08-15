package com.egineering.temportalurlutil.web;

import com.egineering.temportalurlutil.data.TemporalUrlRepository;
import com.egineering.temportalurlutil.domain.TemporalUrl;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Date;

/**
 * Created by tkelley on 1/17/2016.
 */

@Controller
public class RootController {

    private static final Logger log = LoggerFactory.getLogger(RootController.class);

    @Value("${ENV_PARTICLE_DEVICE_ID}")
    private String particleDeviceId;

    @Value("${ENV_PARTICLE_ACCESS_TOKEN}")
    private String particleAccessToken;

    @Autowired
    private TemporalUrlRepository repository;

    String particleUrl = "https://api.particle.io/v1/devices/%s/setpos/";

    @RequestMapping(path = "/", method = RequestMethod.GET)
    String index() {
        return "index";
    }

    @RequestMapping(path = "/feedSuccess", method = RequestMethod.GET)
    String feedSuccess() {
        return "feedSuccess";
    }

    @RequestMapping(path = "/{urlToken}", method = RequestMethod.GET)
    String processGarageDoorRequest(@PathVariable String urlToken) {

        try {

            // Check to see if the URL token is valid
            TemporalUrl url = repository.findByUrlToken(urlToken);

            if (url.getExpirationDate().after(new Date()) && url.getEffectiveDate().before(new Date())) {
                // You may do the thing
                log.debug("URL: " + String.format(particleUrl, particleDeviceId));

                /*OkHttpClient client = new OkHttpClient();

                RequestBody formBody = new FormBody.Builder()
                        .add("access_token", particleAccessToken)
                        .build();

                Request request = new Request.Builder()
                        .url(String.format(particleUrl, particleDeviceId))
                        .post(formBody)
                        .build();

                Response response = client.newCall(request).execute();*/
                //log.debug(response.body().string());

            } else {
                // Access denied
            }



        } catch (Exception e) {
            log.error("Something bad happened while attempting to call particle endpoint", e);
        }


        return "redirect:/feedSuccess";
    }

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    String createUser() {

        try {

            // Check to see if the URL token is valid
            repository.save(new TemporalUrl("Troy", "Kelley", new Date(), new Date(),
                    "aToken!"));


        } catch (Exception e) {
            log.error("Something bad happened while attempting to call particle endpoint", e);
        }


        return "redirect:/feedSuccess";
    }
}