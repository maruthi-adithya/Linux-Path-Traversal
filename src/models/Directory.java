package models;
import java.util.ArrayList;
import java.util.List;

public class Directory {

	private String name = null;

	private List<Directory> children = new ArrayList<>();

	private Directory parent = null;

	public Directory(String name) {
		this.name = name;
	}

	public Directory addChild(Directory child) {
		child.setParent(this);
		this.children.add(child);
		return child;
	}

	public void addChildren(List<Directory> children) {
		children.forEach(each -> each.setParent(this));
		this.children.addAll(children);
	}

	public List<Directory> getChildren() {
		return children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private void setParent(Directory parent) {
		this.parent = parent;
	}

	public Directory getParent() {
		return parent;
	}

	public Directory getRoot() {
		if (parent == null) {
			return this;
		}
		return parent.getRoot();
	}
	
	public void printTree(Directory directory, String appender) {
		System.out.println(appender + directory.getName());
		directory.getChildren().forEach(each -> printTree(each, appender + appender));
	}

	public void deleteNode() {
		if (parent != null) {
			int index = this.parent.getChildren().indexOf(this);
			this.parent.getChildren().remove(this);
			for (Directory each : getChildren()) {
				each.setParent(this.parent);
			}
			this.parent.getChildren().addAll(index, this.getChildren());
		} else {
			deleteRootNode();
		}
		this.getChildren().clear();
	}

	public Directory deleteRootNode() {
		if (parent != null) {
			throw new IllegalStateException("Delete Root Node not called on root");
		}
		Directory newParent = null;
		if (!getChildren().isEmpty()) {
			newParent = getChildren().get(0);
			newParent.setParent(null);
			getChildren().remove(0);
			for (Directory each : getChildren()) {
				each.setParent(newParent);
			}
			newParent.getChildren().addAll(getChildren());
		}
		this.getChildren().clear();
		return newParent;
	}

}
