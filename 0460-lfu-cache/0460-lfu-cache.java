class LFUCache {

	private int cap;
	private int min = 1;
	Map<Integer,Integer> keyValueMap= new HashMap<>();
	Map<Integer,Integer> keyFrequencyMap = new HashMap<>();
	Map<Integer,LinkedHashSet<Integer>> freqKeysMap = new HashMap<>();

	public LFUCache(int capacity) {
		cap = capacity;
		freqKeysMap.put(1,new LinkedHashSet<>());
	}
    public int get(int key) {
        if(!keyValueMap.containsKey(key)) {
			return -1;
		}
        int frequency = keyFrequencyMap.get(key);
        keyFrequencyMap.put(key,frequency+1);
        freqKeysMap.get(frequency).remove(key);
        if(frequency==min && freqKeysMap.get(frequency).size()==0) {
            	min++;
		} 
		if(!freqKeysMap.containsKey(frequency+1)) {
			freqKeysMap.put(frequency + 1, new LinkedHashSet<>());
		}
		freqKeysMap.get(frequency+1).add(key);
	    return keyValueMap.get(key);
	}
    public void put(int key, int value) {
		
		if(keyValueMap.containsKey(key))
		{
			keyValueMap.put(key,value);
            get(key); // important --------------------------------------------------------***
            return;
		}
		if(keyValueMap.size()>=cap)
		{
			int keyToremove = freqKeysMap.get(min).iterator().next();
			freqKeysMap.get(min).remove(keyToremove);
			keyValueMap.remove(keyToremove);
			keyFrequencyMap.remove(keyToremove);
		}
		// key is not present in the KeyValueMap
		keyValueMap.put(key,value);
		keyFrequencyMap.put(key,1);
		min = 1;
		freqKeysMap.get(1).add(key);

	}
}