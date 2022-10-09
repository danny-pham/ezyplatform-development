/*
 * Copyright 2022 youngmonkeys.org
 * 
 * Licensed under the ezyplatform, Version 1.0.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     https://youngmonkeys.org/licenses/ezyplatform-1.0.0.txt
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.youngmonkeys.ezyplatform.service;

public interface DictionaryService {

    String translate(String input);

    default Character transaction(int input) {
        String answer = translate(String.valueOf(input));
        return answer == null ? null : answer.charAt(0);
    }

    String translateToAsciiString(String input);

    default String translateToStringInDashCase(
        String input
    ) {
        return translateToAsciiString(input)
            .toLowerCase()
            .replace('\t', '-')
            .replace(' ', '-');
    }
}
