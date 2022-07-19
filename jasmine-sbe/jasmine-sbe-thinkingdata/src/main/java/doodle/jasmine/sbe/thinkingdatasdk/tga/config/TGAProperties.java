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
package doodle.jasmine.sbe.thinkingdatasdk.tga.config;

import static doodle.jasmine.sbe.thinkingdatasdk.tga.TGAConstants.*;

import doodle.jasmine.sbe.thinkingdatasdk.tga.TGAConsumerType;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(PREFIX)
public class TGAProperties {
  private String serverUri = DEFAULT_SERVER_URI;
  private String appId;
  private boolean enableUUID = DEFAULT_ENABLE_UUID;
  private final TGAConsumerType consumerType = DEFAULT_CONSUMER_TYPE;
  private final TGADebugProperties debug = new TGADebugProperties();
  private final TGALoggingProperties logging = new TGALoggingProperties();
  private final TGABatchProperties batch = new TGABatchProperties();
}
