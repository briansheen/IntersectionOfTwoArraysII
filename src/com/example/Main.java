package com.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2};
        int[] nums2 = {1, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));

    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> n1 = new HashMap<>();
        Map<Integer, Integer> n2 = new HashMap<>();
        Set<Integer> nums = new HashSet<>();
        List<Integer> solution = new ArrayList<>();
        for (int i : nums1) {
            if (n1.containsKey(i)) {
                n1.put(i, n1.get(i) + 1);
            } else {
                n1.put(i, 1);
            }
        }
        for (int i : nums2) {
            if (n2.containsKey(i)) {
                n2.put(i, n2.get(i) + 1);
            } else {
                n2.put(i, 1);
            }
        }
        for (int i : nums1) {
            nums.add(i);
        }
        for (int i : nums2) {
            nums.add(i);
        }
        Iterator<Integer> iterator = nums.iterator();
        while (iterator.hasNext()) {
            int index = iterator.next();
            if (n1.containsKey(index) && n2.containsKey(index)) {
                if (n1.get(index) < n2.get(index)) {
                    for (int i = 0; i < n1.get(index); ++i) {
                        solution.add(index);
                    }
                } else {
                    for (int i = 0; i < n2.get(index); ++i) {
                        solution.add(index);
                    }
                }
            }
        }
        int[] intersect = new int[solution.size()];
        for (int i = 0; i < solution.size(); ++i) {
            intersect[i] = solution.get(i);
        }

        return intersect;


//        Map<Integer, Integer> solution = new HashMap<>();
//        List<Integer> intersect = new ArrayList<>();
//        if (nums1.length >= nums2.length) {
//            for (int i = 0; i < nums2.length; ++i) {
//                if (solution.containsKey(nums2[i])) {
//                    solution.put(nums2[i], solution.get(nums2[i]) + 1);
//                } else {
//                    solution.put(nums2[i], 1);
//                }
//            }
//            for (int i = 0; i < nums1.length; ++i) {
//                if (solution.containsKey(nums1[i])) {
//                    solution.put(nums1[i], solution.get(nums1[i]) - 1);
//                } else {
//                    solution.put(nums1[i], 1);
//                }
//            }
//            for (int i = 0; i < nums2.length; ++i) {
//                if (solution.get(nums2[i]) <= 0) {
//                    intersect.add(nums2[i]);
//                }
//            }
//        } else {
//            for (int i = 0; i < nums1.length; ++i) {
//                if (solution.containsKey(nums1[i])) {
//                    solution.put(nums1[i], solution.get(nums1[i]) + 1);
//                } else {
//                    solution.put(nums1[i], 1);
//                }
//            }
//            for (int i = 0; i < nums2.length; ++i) {
//                if (solution.containsKey(nums2[i])) {
//                    solution.put(nums2[i], solution.get(nums2[i]) - 1);
//                } else {
//                    solution.put(nums2[i], 1);
//                }
//            }
//            for (int i = 0; i < nums1.length; ++i) {
//                if (solution.get(nums1[i]) <= 0) {
//                    intersect.add(nums1[i]);
//                }
//            }
//        }
//        int[] intersectArray = new int[intersect.size()];
//        for (int i = 0; i < intersect.size(); ++i) {
//            intersectArray[i] = intersect.get(i);
//        }
//        return intersectArray;
    }
}
