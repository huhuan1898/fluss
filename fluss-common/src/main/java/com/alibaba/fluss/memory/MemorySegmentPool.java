/*
 * Copyright (c) 2024 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.fluss.memory;

import com.alibaba.fluss.annotation.Internal;

import java.util.List;

/** MemorySegment pool to hold pages in memory. */
@Internal
public interface MemorySegmentPool extends MemorySegmentSource {

    /**
     * Get the page size of each page this pool holds.
     *
     * @return the page size
     */
    int pageSize();

    /**
     * Get the total size of this pool.
     *
     * @return the total size
     */
    int totalSize();

    /**
     * Return one page back into this pool.
     *
     * @param segment the page which want to be returned.
     */
    void returnPage(MemorySegment segment);

    /**
     * Return all pages back into this pool.
     *
     * @param memory the pages which want to be returned.
     */
    void returnAll(List<MemorySegment> memory);

    /** @return Free page number. */
    int freePages();

    void close();
}
