package eulertour;

public class Path {
	private PathNode start;	
	private PathNode currNode;
	
	public Path(){
		
	}	
	
	private class EulerPathNode implements PathNode{
		private PathNode prev;
		private PathNode next;
		int data;
		EulerPathNode(int data){
			this.data = data;
			this.prev = this;
			this.next = this;
		}
		
		@Override
		public int getData() {			
			return data;
		}
		@Override
		public PathNode getPrev() {			
			return prev;
		}
		@Override
		public PathNode getNext() {		
			return next;
		}

		@Override
		public void setNext(PathNode n) {
			this.next = n;			
		}

		@Override
		public void setPrev(PathNode n) {
			this.prev = n;			
		}
		 
		@Override
		public PathNode splice(Path p) {
			if( p != null ){
				PathNode st = p.getStart();
				PathNode ed = p.getEnd();
				
				PathNode nxt = this.next;
				if( st != null ){
					st.setPrev(this);
					this.setNext(st);
					ed.setNext(nxt);
					nxt.setPrev(ed);
				}
			}
			return this;
		}				
	}
	
	public PathNode getStart(){
		return start;
	}
	
	public PathNode getEnd(){
		if(start == null) return null;
		return start.getPrev();
	}	
	
	public void move(){		
		currNode = currNode.getNext();		
	}
	
	public PathNode getCurrNode(){
		return currNode;
	}
	
		

	
	public void add(int id){
		PathNode node = new EulerPathNode(id);
		if(start == null ){
			start = node;
			currNode = node;
		}
		else{
			PathNode end = start.getPrev();
			end.setNext(node);
			node.setPrev(end);
			node.setNext(start);
			start.setPrev(node);
			
		}
	}
	
	public void printPath(){
		PathNode temp = start;
		if(temp == null ){
			System.out.println("No path to display");
			return;
		}
		do{
			System.out.print(temp.getData() + " --> ");
			temp = temp.getNext();
		} while(temp != start);
		System.out.print("|end-");
	}
	

}
