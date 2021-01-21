package com.shunyi.trainingcontext.ohs.remote.resources;

import com.shunyi.ddd.core.gateway.ohs.Resources;
import com.shunyi.ddd.core.stereotype.Remote;
import com.shunyi.ddd.core.stereotype.RemoteType;
import com.shunyi.trainingcontext.ohs.local.appservices.TrainingAppService;
import com.shunyi.trainingcontext.ohs.local.pl.TrainingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Logger;

/**
 * @author zhang
 * @create 2021-01-12 17:54
 */
@RestController
@RequestMapping("/trainings")
@Remote(RemoteType.Resource)
public class TrainingResource {
    private Logger logger = Logger.getLogger(TrainingResource.class.getName());

    @Autowired
    private TrainingAppService trainingAppService;

    @GetMapping("/{id}")
    public ResponseEntity<TrainingResponse> findBy(@PathVariable String id) {
        return Resources.with("find training by id")
                .onSuccess(HttpStatus.OK)
                .onError(HttpStatus.BAD_REQUEST)
                .onFailed(HttpStatus.NOT_FOUND)
                .execute(() -> trainingAppService.trainingOf(id));
    }
}