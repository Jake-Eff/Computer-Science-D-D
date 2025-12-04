import java.util.ArrayList;
import java.util.List;

/**
 * Represents a directory in the file system tree. A directory can contain other directories and
 * files as children.
 */
public class FolderNode extends FileSystemNode {

    private List<FileSystemNode> children;

    public FolderNode(String name, FolderNode parent) {
        super(name, parent);
        this.children = new ArrayList<>();
    }


    @Override
    public boolean isFolder() {
        if (this instanceof FolderNode) {
            return true;
        }

        return false;
    }

    /**
     * Returns a list view of the children contained directly inside this directory. Modifying the
     * returned list is not required to be supported.
     */
    public List<FileSystemNode> getChildren() {
        List<FileSystemNode> defensiveChildren = new ArrayList<FileSystemNode>(children.size());
        for (FileSystemNode filesysnode : children) {
            defensiveChildren.add(filesysnode);
        }
        return defensiveChildren;
    }

    /**
     * Searches the children of this directory for a node whose name matches the input. Only direct
     * children are considered, not deeper descendants.
     */
    public FileSystemNode getChildByName(String childName) {
        for (FileSystemNode child : children) {
            if (child.getName().equals(childName)) {
                return child;
            }
        }
        return null;
    }

    /**
     * Creates a new file directly inside this directory with the given name and size. If a child
     * with the same name already exists, no file is created and false is returned. Otherwise the
     * new file is added and true is returned.
     */
    public boolean addFile(String fileName, int size) {
        if (getChildByName(fileName) != null) {
            return false;
        }
        children.add(new FileNode(getParent(), fileName, size));
        return true;
    }

    /**
     * Creates a new subdirectory directly inside this directory with the given name. If a child
     * with the same name already exists, no folder is created and false is returned. Otherwise the
     * new folder is added and true is returned.
     */
    public boolean addFolder(String folderName) {
        if (getChildByName(folderName) != null) {
            return false;
        }
        children.add(new FolderNode(folderName, getParent()));
        return true;
    }

    /**
     * Searches this directory and all of its descendants for nodes whose name matches the input.
     * When a match is found, its full path can be printed by the caller using toString().
     */
    public boolean containsNameRecursive(String searchName) {
        if (this.getName().equals(searchName)) {
            this.toString();
            return true;
        }
        for (FileSystemNode child : children) {
            if (child.isFolder()) {
                FolderNode f = (FolderNode) child;
                f.containsNameRecursive(searchName);
            } else {
                if (child.getName().equals(searchName)) {
                    child.toString();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int getHeight() {
        List<FileSystemNode> children = this.getChildren();
        int greatestHeight = 0;
        if (!this.isFolder() || children.size() == 0) {
            return 0;
        } else if (this.isFolder()) {
            for (int i = 0; i < children.size(); i++) {
                int thisChildHeight = children.get(i).getHeight();
                if (thisChildHeight > greatestHeight) {
                    greatestHeight = thisChildHeight;
                }
            }
        }
        return greatestHeight + 1;
    }

    @Override
    public int getSize() {
        List<FileSystemNode> children = this.getChildren();
        int size = 0;
        if (!this.isFolder()) {
            return this.getSize();
        } else if (children.size() == 0) {
            return 0;
        } else if (this.isFolder()) {
            for (int i = 0; i < children.size(); i++) {
                size += children.get(i).getSize();
            }
        }
        return size;
    }

    @Override
    public int getTotalNodeCount() {
        List<FileSystemNode> children = this.getChildren();
        int total = 0;
        if (!this.isFolder()) {
            return this.getSize();
        } else if (children.size() == 0) {
            return 1;
        } else if (this.isFolder()) {
            for (int i = 0; i < children.size(); i++) {
                total += children.get(i).getTotalNodeCount();
            }
        }
        return total + 1;
    }
}
