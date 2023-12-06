package pack;

public class HashTable_LinearProbe extends HashTable{
	public Chain[] Table;
	
	public int Size;
	
	public HashTable_LinearProbe(int Size) {
		this.Size = Size;
		this.Table = new Chain[Size];
		for(int i = 0; i < Size; i++) {
			this.Table[i] = new Chain();
		}
	}
	
	//hashing is the process to translate a key into a value for indexing/searching
	private int Hashing(int key) {
		//use modulo for the hashing
		int result = key % this.Size;
		return result;
	}

	@Override
	public void HashInsert(int key, int value) {
	    int index = Hashing(key);
	    Chain target = Table[index];

	    while (target != null && target.Header != null) {
	        index = (index + 1) % Size;
	        target = Table[index];
	    }

	    if (target == null) {
	        Chain result = new Chain();
	        result.InsertNode(key, value);
	        Table[index] = result;
	    } else {
	        target.InsertNode(key, value);
	    }
	}

	@Override
	public boolean HashSearch(int key) {
		int index = Hashing(key);
		Chain target = Table[index];
		int counter = 0;
		
		while(target.SearchByKey(key)== false && counter < this.Size)
		{
			index = (index + 1) % Size;
			target = Table[index];
			counter++;
		}
		return target.SearchByKey(key);
	}

	@Override
	public void HashDelete(int key) {
		int index = Hashing(key);
		Chain target = Table[index];
		int counter = 0;
		
		while(target.SearchByKey(key)== false && counter < this.Size)
		{
			index = (index + 1) % Size;
			target = Table[index];
			counter++;
		}
		if(target.SearchByKey(key) == true)
		{
			target.DeleteNodeByKey(key);
		}
	}

	
	@Override
	public String toString() {
		String output = "";
		for(int i = 0; i < this.Size; i++) {
			output += "[" + i + "]: " + this.Table[i].toString() + "\n";
		}
		return output;
	}
}
