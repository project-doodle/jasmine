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
package doodle.jasmine.sbe.thinkingdata.tga.config;

import cn.thinkingdata.tga.javasdk.DynamicSuperPropertiesTracker;
import cn.thinkingdata.tga.javasdk.ThinkingDataAnalytics;
import doodle.jasmine.sbe.thinkingdata.tga.TGAPlusDynamicSuperPropertiesTracker;
import doodle.jasmine.sbe.thinkingdata.tga.TGAPlusOpaqueContext;
import doodle.jasmine.sbe.thinkingdata.tga.TGAPlusTracker;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration(proxyBeanMethods = false)
@AutoConfigureAfter(TGAAutoConfiguration.class)
@ConditionalOnBean(ThinkingDataAnalytics.class)
public class TGAPlusAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public DynamicSuperPropertiesTracker tgaDynamicSuperPropertiesTracker(
      ObjectProvider<TGAPlusDynamicSuperPropertiesTracker> trackerProvider) {
    return () ->
        trackerProvider
            .getIfUnique(() -> new TGAPlusDynamicSuperPropertiesTracker() {})
            .apply(TGAPlusOpaqueContext.current());
  }

  @Bean
  @ConditionalOnMissingBean
  public TGAPlusTracker tgaPlusTracker(ThinkingDataAnalytics tga) {
    return new TGAPlusTracker(tga);
  }
}
