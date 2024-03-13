/*
 * Copyright 2013 Signal Messenger, LLC
 * SPDX-License-Identifier: AGPL-3.0-only
 */

package org.whispersystems.textsecuregcm.configuration;

import java.util.Map;
import javax.validation.constraints.NotNull;

public record RemoteConfigConfiguration(@NotNull Map<String, String> globalConfig) {

}
