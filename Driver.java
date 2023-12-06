package pack;

public class Driver {

	public static void main(String[] args) {
		HashTable_Chaining hash = new HashTable_Chaining(10);
		HashTable_LinearProbe hashLin = new HashTable_LinearProbe(10);
		hash.HashInsert(10, 10);
		hash.HashInsert(20, 20);
		hash.HashInsert(11, 11);
		hash.HashInsert(22, 22);
		//System.out.println(hash);
		
		hashLin.HashInsert(10,10);
		hashLin.HashInsert(18,18);
		hashLin.HashInsert(96,96);
		hashLin.HashInsert(21,21);
		hashLin.HashInsert(29,29);
		hashLin.HashInsert(35,35);
		hashLin.HashInsert(42,42);
		hashLin.HashInsert(88,88);
		hashLin.HashInsert(66,66);
		hashLin.HashInsert(9,9);
		System.out.println(hashLin);
		
		System.out.println(hashLin.HashSearch(96));
		System.out.println(hashLin.HashSearch(14));
		
		hashLin.HashDelete(29);
		
		System.out.println(hashLin);
		
		

	}

}
