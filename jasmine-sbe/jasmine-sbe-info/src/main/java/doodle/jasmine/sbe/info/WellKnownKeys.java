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

// https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#getProperties--
public interface WellKnownKeys {
  String JAVA_VERSION = "java.version";
  String JAVA_VENDOR = "java.vendor";
  String JAVA_VENDOR_URL = "java.vendor.url";
  String JAVA_HOME = "java.home";
  String JAVA_CLASS_VERSION = "java.class.version";
  String JAVA_CLASS_PATH = "java.class.path";
  String JAVA_LIBRARY_PATH = "java.library.path";
  String JAVA_IO_TMPDIR = "java.io.tmpdir";
  String JAVA_COMPILER = "java.compiler";
  String JAVA_EXT_DIRS = "java.ext.dirs";
  String JAVA_VM_NAME = "java.vm.name";
  String JAVA_VM_VERSION = "java.vm.version";
  String JAVA_VM_VENDOR = "java.vm.vendor";
  String JAVA_VM_INFO = "java.vm.info";
  String JAVA_VM_SPEC_NAME = "java.vm.specification.name";
  String JAVA_VM_SPEC_VERSION = "java.vm.specification.version";
  String JAVA_VM_SPEC_VENDOR = "java.vm.specification.vendor";
  String JAVA_SPEC_NAME = "java.specification.name";
  String JAVA_SPEC_VERSION = "java.specification.version";
  String JAVA_SPEC_VENDOR = "java.specification.vendor";
  String OS_NAME = "os.name";
  String OS_ARCH = "os.arch";
  String OS_VERSION = "os.version";
  String USER_NAME = "user.name";
  String USER_HOME = "user.home";
  String USER_DIR = "user.dir";
}
