package io.jvmd.api.data;

import com.badlogic.gdx.physics.box2d.World;
import io.jvmd.api.preferences.Config;
import io.jvmd.api.world.BPBWorld;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;

public enum ECategory implements BPBPackage {

    WORLD {
        @Override
        public String getLocation() {
            return "world";
        }
    },
    PREFERENCES {
        @Override
        public String getLocation() {
            return "preferences";
        }
    },
    ACTOR {
        @Override
        public String getLocation() {
            return "actor";
        }
    };

    @Override
    public Object load(String link) throws IOException, ClassNotFoundException {
        StringBuilder builder = new StringBuilder();
        builder.append(Config.getPrefix());
        builder.append("/").append(getLocation()).append("/").append(link);

        ObjectInputStream ois = new ObjectInputStream(new URL(builder.toString()).openStream());

        Object obj = ois.readObject();
        ois.close();

        return obj;
    }


    private final PackageSaver saver = new PackageSaver();

    @Override
    public void save(PackageNode node) throws IOException {
        getSaver().save(node, this);
    }

    // todo make package load

    @Override
    public PackageSaver getSaver() {
        return saver;
    }

}
