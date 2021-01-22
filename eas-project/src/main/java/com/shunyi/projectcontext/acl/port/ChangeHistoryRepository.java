package com.shunyi.projectcontext.acl.port;

import com.shunyi.ddd.core.stereotype.Port;
import com.shunyi.ddd.core.stereotype.PortType;
import com.shunyi.projectcontext.domain.changehistory.ChangeHistory;

/**
 * @author zhang
 */
@Port(PortType.Repository)
public interface ChangeHistoryRepository {
    void add(ChangeHistory changeHistory);
}
