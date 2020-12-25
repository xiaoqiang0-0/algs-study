package com.xiaoqiang.algs.lc;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 */
public class LC4 {
    public static void main(String[] args) {
        System.out.println(new LC4().findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{1, 2, 2}));
    }

    /**
     * 参考归并思想，合并两个有序数组，但是由于并不需要最终的合并后结果，因此只需要记录上一个操作的元素位于哪一个数组即可
     * 先计计算出两个数组合并后是否为奇数个，如果是则直接去两个元素的最中间元素返回即可，否则取 (中间位置元素+上一个最大值元素)/2 即可。
     * 如果其中一个数组已经全部访问，则直接按照此逻辑处理另一个即可
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalCount = nums1.length + nums2.length;
        boolean isDouble = (totalCount & 1) == 0;
        int index1 = 0;
        int index2 = 0;
        int m = totalCount >> 1;
        boolean lastFrom1 = false;
        for (int i = 0; i < totalCount; i++) {

            if (nums1.length > index1 && nums2.length > index2) {
                if (nums1[index1] > nums2[index2]) {
                    if (i == m && !isDouble) {
                        return nums2[index2];
                    }
                    if (i == m) {
                        if (lastFrom1) {
                            return (nums1[index1 - 1] + nums2[index2]) / (double) 2;
                        } else {
                            return (nums2[index2 - 1] + nums2[index2]) / (double) 2;
                        }
                    }
                    index2++;
                    lastFrom1 = false;
                } else {
                    if (i == m && !isDouble) {
                        return nums1[index1];
                    }
                    if (i == m) {
                        if (lastFrom1) {
                            return (nums1[index1 - 1] + nums1[index1]) / (double) 2;
                        } else {
                            return (nums2[index2 - 1] + nums1[index1]) / (double) 2;
                        }
                    }
                    index1++;
                    lastFrom1 = true;
                }
            } else {
                boolean nums1IsEnd;
                nums1IsEnd = nums1.length == index1;
                int[] nums = nums1IsEnd ? nums2 : nums1;
                if (i == m && !isDouble) {
                    return nums[nums1IsEnd ? index2 : index1];
                }
                if (i == m) {
                    if (lastFrom1) {
                        return (nums1[index1 - 1] + (nums1IsEnd ? nums2[index2] : nums1[index1])) / (double) 2;
                    } else {
                        return (nums2[index2 - 1] + (nums1IsEnd ? nums2[index2] : nums1[index1])) / (double) 2;
                    }
                }
                if (nums1IsEnd) {
                    index2++;
                    lastFrom1 = false;
                } else {
                    index1++;
                    lastFrom1 = true;
                }
            }
        }
        return 0;
    }
}
