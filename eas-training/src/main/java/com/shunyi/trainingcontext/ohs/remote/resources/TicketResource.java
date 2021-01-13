package com.shunyi.trainingcontext.ohs.remote.resources;

import com.shunyi.ddd.core.gateway.ohs.Resources;
import com.shunyi.trainingcontext.ohs.local.appservices.NominationAppService;
import com.shunyi.trainingcontext.ohs.local.pl.NominatingCandidateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author zhang
 * @create 2021-01-12 17:53
 */
@RestController
@RequestMapping("/tickets")
public class TicketResource {
    private Logger logger = Logger.getLogger(TicketResource.class.getName());

    @Autowired
    private NominationAppService nominationAppService;

    @PutMapping
    public ResponseEntity<?> nominate(@RequestBody NominatingCandidateRequest nominatingCandidateRequest) {
        return Resources.with("nominate ticket")
                .onSuccess(HttpStatus.ACCEPTED)
                .onError(HttpStatus.BAD_GATEWAY)
                .onFailed(HttpStatus.INTERNAL_SERVER_ERROR)
                .execute(() -> nominationAppService.nominate(nominatingCandidateRequest));
    }
}