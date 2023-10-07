# HashMaps
HashMap in Java stores the data in (Key, Value) pairs, and you can access them by an index of another type (e.g. an Integer). One object is used as a key (index) to another object (value).

## Features:
Here are some of the features of a HashMap:

1) Items are stored in key/value pairs.

2) Items do not maintain any order when added. The data is unordered.

3) In a case where there are duplicate keys, the last one will override the other(s).

4) Data types are specified using wrapper classes instead of primitive data types.

## Syntax:
#### HashMap<KeyDataType, ValueDataType> HashMapName = new HashMap<>();

Here's an example to simplify the terms:

HashMap<Integer, String> StudentInfo = new HashMap<>();

## HashMap Internal Structure

![image](https://github.com/coding-with-parthasarathi/HashMaps/assets/81622322/26e96353-555b-4d0e-99e0-a794b9139e0f)

The above image roughly shows how the HashMap stores its elements. Internally it uses an array of Entry<K, V> class called table[] to store the key-value pairs. But how HashMap allocates slot in table[] array to each of its key-value pair is very interesting. It doesn’t inserts the objects as you put them into HashMap i.e first element at index 0, second element at index 1 and so on. Instead it uses the hashcode of the key to decide the index for a particular key-value pair. It is called Hashing.

The whole HashMap data structure is based on the principle of Hashing. Hashing is nothing but the function or algorithm or method which when applied on any object/variable returns an unique integer value representing that object/variable. This unique integer value is called hash code.

## Hierarchy of HashMap in Java

![image](https://github.com/coding-with-parthasarathi/HashMaps/assets/81622322/faa25f02-0708-4856-9a01-0751ca03124a)

## Important Methods Of HashMap In Java:

#### 1) public V put(K key, V value)

This method inserts specified key-value mapping in the map. If map already has a mapping for the specified key, then it rewrites that value with new value.

#### 2) public void putAll(Map m)

This method copies all of the mappings of the map m to this map.

#### 3) public V get(Object key)

This method returns the value associated with a specified key.

#### 4) public int size()

This method returns the number of key-value pairs in this map.

#### 5) public boolean isEmpty()

This method checks whether this map is empty or not.

#### 6) public boolean containsKey(Object key)

This method checks whether this map contains the mapping for the specified key.

#### 7) public boolean containsValue(Object value)

This method checks whether this map has one or more keys mapping to the specified value.

#### 8) public V remove(Object key)

This method removes the mapping for the specified key.

#### 9) public void clear()

This method removes all the mappings from this map.

#### 10) public Set<K> keySet()

This method returns the Set view of the keys in the map.

#### 11) public Collection<V> values()

This method returns Collection view of the values in the map.

#### 12) public Set<Map.Entry<K, V>> entrySet()

This method returns the Set view of all the mappings in this map.

#### 13) public V putIfAbsent(K key, V value)

This method maps the given value with specified key if this key is currently not associated with a value or mapped to a null.

#### 13) public boolean remove(Object key, Object value)

This method removes the entry for the specified key if this key is currently mapped to a specified value.

#### 14) public boolean replace(K key, V oldValue, V newValue)

This method replaces the oldValue of the specified key with newValue if the key is currently mapped to oldValue.

#### 15) public V replace(K key, V value)

This method replaces the current value of the specified key with new value.
