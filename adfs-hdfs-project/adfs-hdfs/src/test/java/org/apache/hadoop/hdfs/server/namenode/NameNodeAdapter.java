/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hdfs.server.namenode;
import java.io.IOException;
import org.apache.hadoop.hdfs.protocol.Block;


public abstract class NameNodeAdapter {
  public static boolean checkFileProgress(FSNamesystem fsn, String path, boolean checkall) throws IOException {
    int fid = fsn.stateManager.getFileInfo(path).id;
    DbNodeFile file = fsn.fileManager.getFile(fid);
    return fsn.checkFileProgress(file, checkall);
  }

  public static long callNextGenerationStampForBlock(
    FSNamesystem fsn, Block block, boolean fromNN) throws IOException {
    return fsn.nextGenerationStampForBlock(block, fromNN);
  }

}
