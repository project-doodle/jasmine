/*
 * Copyright (c) 2022-present Doodle. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package doodle.jasmine.sbe.thinkingdatasdk.tga;

import static doodle.jasmine.sbe.thinkingdatasdk.tga.TGAConsumerType.DEBUG;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class TGAConstants {
  public static final String PREFIX = "doodle.jasmine.sbe.thinkingdatasdk.tga";

  public static final String DEFAULT_SERVER_URI = "https://global-receiver-ta.thinkingdata.cn";
  public static final boolean DEFAULT_ENABLE_UUID = false;
  public static final TGAConsumerType DEFAULT_CONSUMER_TYPE = DEBUG;
  public static final boolean DEFAULT_DEBUG_WRITE_DATA = false;
  public static final String DEFAULT_LOGGING_LOG_DIRECTORY = ".logs/tga";
}
