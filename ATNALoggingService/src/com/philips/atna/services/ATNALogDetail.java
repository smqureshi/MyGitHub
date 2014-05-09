package com.philips.atna.services;

import com.philips.atna.beans.ATNALog;
import com.philips.atna.beans.ATNALogStore;

/**
 * @author Waqas
 * @author Shahid
 *
 */

public interface ATNALogDetail {
    ATNALog getLogDetail(final String appLogID);

    ATNALogStore getFilteredLogs(final ATNALog filterBean,final String endTime, final Integer pageNum);
}
