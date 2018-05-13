class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Long> map = Arrays.stream(nums1)
        								.boxed()
        								.collect(Collectors.groupingBy(e->e, Collectors.counting()));
		int[] arr = Arrays.stream(nums2)
						.filter(e->{if(map.containsKey(e)){
									long count = map.get(e);
									if(count == 1) map.remove(e);
									else map.put(e, count-1);
									return true;
								}
								return false;
							}).toArray();
		return arr;
    }
}