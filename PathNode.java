package eulertour;

public interface PathNode {
	int getData();
	PathNode getPrev();
	PathNode getNext();
	void setNext(PathNode n);
	void setPrev(PathNode n);
	PathNode splice(Path p); // this node acts as detour and this detour is spliced to the given path p
}
