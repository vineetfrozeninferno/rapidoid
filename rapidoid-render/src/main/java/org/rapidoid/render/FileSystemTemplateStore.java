package org.rapidoid.render;

/*
 * #%L
 * rapidoid-render
 * %%
 * Copyright (C) 2014 - 2016 Nikolche Mihajlovski and contributors
 * %%
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
 * #L%
 */

import org.rapidoid.RapidoidThing;
import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.Since;
import org.rapidoid.commons.Arr;
import org.rapidoid.io.Res;
import org.rapidoid.u.U;

@Authors("Nikolche Mihajlovski")
@Since("5.2.0")
public class FileSystemTemplateStore extends RapidoidThing implements TemplateStore {

	private final String[] templatesPath;

	public FileSystemTemplateStore(String[] templatesPath) {
		this.templatesPath = withDefaultPath(templatesPath);
	}

	private String[] withDefaultPath(String[] templatesPath) {
		if (U.isEmpty(templatesPath) || U.neq(U.last(templatesPath), Templates.DEFAULT_TEMPLATES_PATH)) {
			return Arr.concat(templatesPath, Templates.DEFAULT_TEMPLATES_PATH);
		} else {
			return templatesPath;
		}
	}

	@Override
	public String loadTemplate(String name) {
		Res res = Res.from(name, templatesPath);
		return res.mustExist().getContent();
	}

}