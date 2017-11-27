package org.openhab.binding.synologysurveillancestation.handler;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.ThingStatusDetail;
import org.eclipse.smarthome.core.thing.binding.BaseBridgeHandler;
import org.eclipse.smarthome.core.types.Command;
import org.openhab.binding.synologysurveillancestation.internal.Config;
import org.openhab.binding.synologysurveillancestation.internal.webapi.SynoWebApiHandler;
import org.openhab.binding.synologysurveillancestation.internal.webapi.WebApiException;
import org.openhab.binding.synologysurveillancestation.internal.webapi.response.InfoResponse;
import org.openhab.binding.synologysurveillancestation.internal.webapi.response.SynoApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SynologySurveillanceStationBridgeHandler extends BaseBridgeHandler {

    private final Logger logger = LoggerFactory.getLogger(SynologySurveillanceStationBridgeHandler.class);

    private SynoWebApiHandler apiHandler = null;

    public SynologySurveillanceStationBridgeHandler(Bridge bridge) {
        super(bridge);
    }

    public SynoWebApiHandler getSynoWebApiHandler() {
        return apiHandler;
    }

    @Override
    public void handleCommand(@NonNull ChannelUID channelUID, @NonNull Command command) {
        // There is nothing to handle in the bridge handler

    }

    @Override
    public void initialize() {

        try {

            updateStatus(ThingStatus.UNKNOWN);

            if (logger.isDebugEnabled()) {
                logger.debug("Initialize thing: {}::{}", getThing().getLabel(), getThing().getUID());
            }

            Config config = getConfigAs(Config.class);
            apiHandler = new SynoWebApiHandler(config);
            apiHandler.connect();

            InfoResponse infoResponse = apiHandler.getInfo();
            getThing().setProperty(SynoApiResponse.PROP_CAMERANUMBER,
                    infoResponse.getData().get(SynoApiResponse.PROP_CAMERANUMBER).getAsString());
            // TODO if needed add other infos

            updateStatus(ThingStatus.ONLINE);

        } catch (WebApiException e) {
            updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.COMMUNICATION_ERROR, "Errorcode: " + e.getErrorCode());
        }

    }
}
