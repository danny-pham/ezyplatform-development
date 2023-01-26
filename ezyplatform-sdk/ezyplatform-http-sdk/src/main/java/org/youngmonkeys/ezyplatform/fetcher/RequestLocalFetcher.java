/*
 * Copyright 2023 youngmonkeys.org
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

package org.youngmonkeys.ezyplatform.fetcher;

import lombok.AllArgsConstructor;
import org.youngmonkeys.ezyplatform.service.LanguageService;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@AllArgsConstructor
public class RequestLocalFetcher {

    private final LanguageService languageService;

    public Locale getLocal(HttpServletRequest request) {
        String lang = request.getParameter("lang");
        if (lang == null) {
            lang = languageService.getDefaultLanguageCode();
        }
        return new Locale(lang);
    }
}
