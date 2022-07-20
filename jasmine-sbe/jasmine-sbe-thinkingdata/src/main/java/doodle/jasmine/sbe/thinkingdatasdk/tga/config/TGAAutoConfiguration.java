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

import static doodle.jasmine.sbe.thinkingdatasdk.tga.TGAConstants.PREFIX;

import cn.thinkingdata.tga.javasdk.Consumer;
import cn.thinkingdata.tga.javasdk.DynamicSuperPropertiesTracker;
import cn.thinkingdata.tga.javasdk.ThinkingDataAnalytics;
import cn.thinkingdata.tga.javasdk.ThinkingDataAnalytics.BatchConsumer;
import cn.thinkingdata.tga.javasdk.ThinkingDataAnalytics.DebugConsumer;
import cn.thinkingdata.tga.javasdk.ThinkingDataAnalytics.LoggerConsumer;
import java.net.URISyntaxException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;

@SpringBootConfiguration(proxyBeanMethods = false)
@ConditionalOnBean(TGAMarkerConfiguration.Marker.class)
@ConditionalOnClass(ThinkingDataAnalytics.class)
@EnableConfigurationProperties(TGAProperties.class)
@ConditionalOnProperty(prefix = PREFIX, name = "app-id")
public class TGAAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public Consumer thinkingDataAnalyticsConsumer(TGAProperties properties)
      throws URISyntaxException {
    switch (properties.getConsumerType()) {
      case DEBUG:
        return new DebugConsumer(
            properties.getServerUri(), properties.getAppId(), properties.getDebug().isWriteData());
      case LOGGING:
        return new LoggerConsumer(properties.getLogging());
      case BATCH:
        return new BatchConsumer(
            properties.getServerUri(), properties.getAppId(), properties.getBatch());
      default:
        throw new Error();
    }
  }

  @Bean
  @ConditionalOnMissingBean
  public ThinkingDataAnalytics thinkingDataAnalytics(
      TGAProperties properties,
      Consumer consumer,
      ObjectProvider<DynamicSuperPropertiesTracker> trackerProvider) {
    ThinkingDataAnalytics tga = new ThinkingDataAnalytics(consumer, properties.isEnableUUID());
    tga.setDynamicSuperPropertiesTracker(trackerProvider.getIfUnique());
    return tga;
  }

  @Bean
  public ApplicationListener<ContextClosedEvent> tgaContextClosedEventListener(
      ThinkingDataAnalytics tga) {
    return (ignored) -> tga.close();
  }
}
