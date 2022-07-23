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
package doodle.jasmine.sbe.info;

import static doodle.jasmine.sbe.info.WellKnownKeys.*;

import java.util.Properties;
import org.springframework.boot.info.InfoProperties;

public class JavaProperties extends InfoProperties {

  public JavaProperties(Properties entries) {
    super(entries);
  }

  public String getVersion() {
    return get(JAVA_VERSION);
  }

  public String getVendor() {
    return get(JAVA_VENDOR);
  }

  public String getVendorUrl() {
    return get(JAVA_VENDOR_URL);
  }

  public String getHome() {
    return get(JAVA_HOME);
  }

  public String getClassVersion() {
    return get(JAVA_CLASS_VERSION);
  }

  public String getClassPath() {
    return get(JAVA_CLASS_PATH);
  }

  public String getLibraryPath() {
    return get(JAVA_LIBRARY_PATH);
  }

  public String getIoTmpDir() {
    return get(JAVA_IO_TMPDIR);
  }

  public String getCompiler() {
    return get(JAVA_COMPILER);
  }

  public String getExtDirs() {
    return get(JAVA_EXT_DIRS);
  }

  public String getSpecName() {
    return get(JAVA_SPEC_NAME);
  }

  public String getSpecVersion() {
    return get(JAVA_SPEC_VERSION);
  }

  public String getSpecVendor() {
    return get(JAVA_SPEC_VENDOR);
  }

  public String getVMName() {
    return get(JAVA_VM_NAME);
  }

  public String getVMVersion() {
    return get(JAVA_VM_VERSION);
  }

  public String getVMVendor() {
    return get(JAVA_VM_VENDOR);
  }

  public String getVMInfo() {
    return get(JAVA_VM_INFO);
  }

  public String getVMSpecName() {
    return get(JAVA_VM_SPEC_NAME);
  }

  public String getVMSpecVersion() {
    return get(JAVA_VM_SPEC_VERSION);
  }

  public String getVMSpecVendor() {
    return get(JAVA_VM_SPEC_VENDOR);
  }
}
