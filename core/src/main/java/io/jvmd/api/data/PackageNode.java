package io.jvmd.api.data;

import java.io.Serializable;

public class PackageNode  implements Serializable {

    private String nodeName;

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }
}
