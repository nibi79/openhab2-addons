/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.synologysurveillancestation;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.smarthome.core.thing.ThingTypeUID;

/**
 * The {@link SynologySurveillanceStationBindingConstants} class defines common constants, which are
 * used across the whole binding.
 *
 * @author Nils - Initial contribution
 */
@NonNullByDefault
public class SynologySurveillanceStationBindingConstants {

    public static final String BINDING_ID = "synologysurveillancestation";

    public static final String DEVICE_ID = "deviceID";

    // List of all Thing Type UIDs
    public static final ThingTypeUID THING_TYPE_CAMERA = new ThingTypeUID(BINDING_ID, "camera");
    public static final ThingTypeUID THING_TYPE_STATION = new ThingTypeUID(BINDING_ID, "station");

    public final static Set<ThingTypeUID> SUPPORTED_THING_TYPES = Collections
            .unmodifiableSet(Stream.of(THING_TYPE_CAMERA, THING_TYPE_STATION).collect(Collectors.toSet()));

    /* List of all config properties */
    public static final String PROTOCOL = "protocol";
    public static final String HOST = "host";
    public static final String PORT = "port";
    public static final String USER_NAME = "username";
    public static final String PASSWORD = "password";
    public static final String SESSION_ID = "sessionID";
    public static final String POLL = "POLL";

    // List of all Channel ids
    public final static String CHANNEL_IMAGE = "image";
    public final static String CHANNEL_RECORD = "record";
    public final static String CHANNEL_ENABLE = "enable";
    public final static String CHANNEL_ZOOM = "zoom";
    public final static String CHANNEL_MOVE = "move";

}
