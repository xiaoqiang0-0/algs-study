# 二分查找
> 二分查找基于数组，因此如果数据量太大则占用较高，所以不介意使用。如果数据量太小，还不如直接遍历。
## 最简单的二分查找
从有序数组中找到目标值下标
```java
    public int search(int[] arr, int target) {
        if (arr == null || arr.length < 1 || arr[0] > target || arr[arr.length - 1] < target) {
            return -1;
        }
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int m = low + ((high - low) >> 1);
            if (arr[m] == target) {
                return m;
            }
            if (arr[m] < target) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }
        return -1;
    }
```
当数组为空，数组第一个元素大于目标值，或最后一个元素小于目标值，则说明不在范围内，直接返回-1
然后循环处理，每次取中，当中点的位置元素等于目标值则直接返回，否则根据与目标值的关系，判断继续查找前边部分还是后边部分。

## 查找第一次出现的下标
最简单的实现如下
```java
    public int search(int[] arr, int target) {
        if (arr == null || arr.length < 1 || arr[0] > target || arr[arr.length - 1] < target) {
            return -1;
        }
        int low = 0, high = arr.length - 1;
        int index = -1;
        while (low <= high) {
            int m = low + ((high - low) >> 1);
            if (arr[m] == target) {
                index = m;
            }
            if (arr[m] < target) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }
        return index;
    }
```
只需要将元素出现的位置记录下来，不要找到后直接返回，就算找到依然往下找。最后将`index`返回即可
当然这儿应该是需要优化的，比如当找到一个位置后，如果下一轮的查找中边界值不等于目标值就可以直接结束了循环，没有必要继续进行了。
也很简单直接在循环入口加入一个边界判断即可入股不满足则直接终止循环
```java
if (arr[high] < target || arr[low] > target) {
    break;
}
```

## 查找最后一次出现的下标
按照上边的第一次出现的下标的逻辑，只需要将判断接下来查找后边部分还是前边部分的判断条件改一下就可以了
```java
    public int search(int[] arr, int target) {
        if (arr == null || arr.length < 1 || arr[0] > target || arr[arr.length - 1] < target) {
            return -1;
        }
        int low = 0, high = arr.length - 1;
        int index = -1;
        while (low <= high) {
            if (arr[high] < target || arr[low] > target) {
                break;
            }
            int m = low + ((high - low) >> 1);
            if (arr[m] == target) {
                index = m;
            }
            if (arr[m] <= target) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }
        return index;
    }
```

## 查找第一个大于等于目标值的下标

首先依然是基于最普通的二分查找修改，这个时候我们在拿到中值后不需要等于目标值了，只需要大于等于目标值就可以了，然后依然不要直接返回结果，继续查询查找前半部分即可
```java
    public int search(int[] arr, int target) {
        if (arr == null || arr.length < 1 || arr[0] > target ) {
            return -1;
        }
        int low = 0, high = arr.length - 1;
        int index = arr.length;
        while (low <= high) {
            int m = low + ((high - low) >> 1);
            if (arr[m] >= target) {
                index = m;
                high = m - 1;
            } else {
                low = m + 1;
            }
        }
        return index;
    }
```
当然为了省去后续的不必要的查找，任然可以在循环入口处加入边界判断
```java
if (arr[high] < target || arr[low] > target) {
    break;
}
```

## 查找最后一个小于等于目标值的下标
与查找第一个大于等于目标值的下标方式类似，也就是需要当中值小于等于目标值，则记录当前下标，并继续查找前半部分，同样可以加入接下来查找的范围的边界判断
```java
    public int search(int[] arr, int target) {
        if (arr == null || arr.length < 1 || arr[0] > target) {
            return -1;
        }
        int low = 0, high = arr.length - 1;
        int index = arr.length;
        while (low <= high) {
            if (arr[low]>target||arr[high]<target) {
                break;
            }
            int m = low + ((high - low) >> 1);
            if (arr[m] > target) {
                high = m - 1;
            } else {
                index = m;
                low = m + 1;
            }
        }
        return index;
    }
```

## 总结
1. 二分法的最大难点就是在边界处理上，也就是大于还是小于，又或者是大于等于小于等于的问题上。
2. 边界问题上前半部分结束区间使用中值下标-1，后半部分其实位置采用中值下标+1，防止陷入死循环。
3. 二分查找的常见四种变异其实总结主要就是在找到目标值后，不要返回下标，判断是否有更符合条件的位置。 为了后续的不必要的继续循环，可以在入口处加一个边界判断，这样一来的话，如果边界校验失败则说明上次找到的元素就是最终的结果，直接终止循环并返回即可。

