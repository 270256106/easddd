package com.shunyi.projectcontext.acl.port;


import com.shunyi.ddd.core.stereotype.Port;
import com.shunyi.ddd.core.stereotype.PortType;
import com.shunyi.projectcontext.domain.issue.Issue;
import com.shunyi.projectcontext.domain.issue.IssueId;

import java.util.Optional;

/**
 * @author zhang
 */
@Port(PortType.Repository)
public interface IssueRepository {
    Optional<Issue> issueOf(IssueId issueId);

    void update(Issue issue);
}
