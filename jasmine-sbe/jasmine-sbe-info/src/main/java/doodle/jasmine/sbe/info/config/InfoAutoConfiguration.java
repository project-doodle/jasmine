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
package doodle.jasmine.sbe.info.config;

import doodle.jasmine.sbe.info.JavaProperties;
import doodle.jasmine.sbe.info.OsProperties;
import doodle.jasmine.sbe.info.SystemProperties;
import doodle.jasmine.sbe.info.UserProperties;
import doodle.jasmine.sbe.info.util.InfoPropertiesUtil;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration(proxyBeanMethods = false)
@AutoConfigureAfter(ProjectInfoAutoConfiguration.class)
public class InfoAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public SystemProperties systemProperties() {
    return new SystemProperties(System.getProperties());
  }

  @Bean
  @ConditionalOnMissingBean
  public JavaProperties javaProperties(SystemProperties properties) {
    return new JavaProperties(InfoPropertiesUtil.filtering(properties, "JAVA"));
  }

  @Bean
  @ConditionalOnMissingBean
  public OsProperties osProperties(SystemProperties properties) {
    return new OsProperties(InfoPropertiesUtil.filtering(properties, "OS"));
  }

  @Bean
  @ConditionalOnMissingBean
  public UserProperties userProperties(SystemProperties properties) {
    return new UserProperties(InfoPropertiesUtil.filtering(properties, "USER"));
  }
}
