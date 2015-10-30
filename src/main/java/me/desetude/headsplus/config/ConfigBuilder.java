/*
 *     Copyright (c) 2015. Desetude (devdesetude@gmail.com)
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.desetude.headsplus.config;

import lombok.Setter;
import lombok.experimental.Accessors;
import me.desetude.headsplus.Builder;
import me.desetude.headsplus.HeadsPlus;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

@Accessors(fluent = true, chain = true)
@Setter
public class ConfigBuilder implements Builder<Config> {

    String fileName;
    //TODO May add support for an other type which would be used for head caching
    ConfigType configType;

    private File dataFolder;

    ConfigBuilder(Plugin plugin) {
        fileName = "config";
        configType = ConfigType.YAML;
        this.dataFolder = plugin.getDataFolder();
    }

    @Override
    public Config build() {
        String extension = configType == ConfigType.YAML ? ".yml" : "";
        File file = new File(dataFolder, fileName + extension);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                LoggerFactory.getLogger(HeadsPlus.class).error("Could not load file " + fileName, ex);
            }
        }
        return new Config(YamlConfiguration.loadConfiguration(file), file);
    }

}
