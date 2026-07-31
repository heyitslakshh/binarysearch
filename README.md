# Binary Search in Java

## What is Binary Search?

**Binary Search** is an efficient searching algorithm used to find an element in a **sorted array**. Instead of checking each element one by one (like Linear Search), Binary Search repeatedly divides the search space in half until the target element is found or the search space becomes empty.

> **Prerequisite:** The array **must be sorted** in ascending or descending order.

---

# How Binary Search Works

Binary Search follows the **Divide and Conquer** approach.

1. Find the middle element of the array.
2. Compare the middle element with the target.
3. If the target is equal to the middle element, return its index.
4. If the target is smaller, search the left half.
5. If the target is larger, search the right half.
6. Repeat until the element is found or the search space becomes empty.

---

# Visualization

Suppose we want to search for **23**.

```text
Array:

Index: 0   1   2   3   4   5   6
Value: 3   8  15  23  35  42  50
```

### Step 1

```text
low = 0
high = 6

Middle = (0 + 6) / 2 = 3

Array[3] = 23
```

Target found.

---

Suppose we search for **42**.

### Step 1

```text
3   8   15   23   35   42   50
            ↑
          mid=23
```

42 > 23

Search right half.

---

### Step 2

```text
35   42   50
     ↑
    mid=42
```

Target found.

---

# Algorithm

```text
Start

↓

low = 0
high = n - 1

↓

while(low <= high)

↓

mid = low + (high - low) / 2

↓

Is arr[mid] == target?

↓

Yes → Return Index

↓

No

↓

Target < arr[mid] ?

↓

Yes → high = mid - 1

↓

No → low = mid + 1

↓

Repeat

↓

Not Found
```

---

# Binary Search in Java (Iterative)

```java
public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {3, 8, 15, 23, 35, 42, 50};

        int target = 35;

        int index = binarySearch(arr, target);

        if (index != -1)
            System.out.println("Element found at index " + index);
        else
            System.out.println("Element not found");

    }
}
```

### Output

```text
Element found at index 4
```

---

# Binary Search (Recursive)

```java
public class BinarySearch {

    static int binarySearch(int[] arr, int target, int low, int high) {

        if (low > high)
            return -1;

        int mid = low + (high - low) / 2;

        if (arr[mid] == target)
            return mid;

        if (target < arr[mid])
            return binarySearch(arr, target, low, mid - 1);

        return binarySearch(arr, target, mid + 1, high);
    }

    public static void main(String[] args) {

        int[] arr = {2, 5, 8, 12, 15, 20, 30};

        System.out.println(binarySearch(arr, 15, 0, arr.length - 1));

    }
}
```

---

# Dry Run

Search **35**

```text
Array

3   8   15   23   35   42   50

low = 0
high = 6

mid = 3

arr[mid] = 23

35 > 23

low = 4
```

Now

```text
35   42   50

low = 4
high = 6

mid = 5

arr[mid] = 42

35 < 42

high = 4
```

Now

```text
35

low = 4
high = 4

mid = 4

Found
```

---

# Time Complexity

| Case | Complexity |
|------|------------|
| Best Case | **O(1)** |
| Average Case | **O(log n)** |
| Worst Case | **O(log n)** |

---

# Space Complexity

### Iterative

```text
O(1)
```

### Recursive

```text
O(log n)
```

(Due to recursive call stack.)

---

# Why Use

Instead of searching every element:

```text
1 2 3 4 5 6 7 8 9 10
```

Linear Search checks:

```
1
2
3
4
5
6
7
8
9
10
```

Binary Search checks:

```
5

↓

8

↓

9
```

Much fewer comparisons.

---

# Binary Search on Descending Array

```java
static int binarySearchDescending(int[] arr, int target) {

    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {

        int mid = low + (high - low) / 2;

        if (arr[mid] == target)
            return mid;

        if (target > arr[mid]) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }

    }

    return -1;
}
```

---

# Order-Agnostic Binary Search

Works for both ascending and descending arrays.

```java
static int orderAgnosticBinarySearch(int[] arr, int target) {

    int low = 0;
    int high = arr.length - 1;

    boolean isAscending = arr[low] < arr[high];

    while (low <= high) {

        int mid = low + (high - low) / 2;

        if (arr[mid] == target)
            return mid;

        if (isAscending) {

            if (target < arr[mid])
                high = mid - 1;
            else
                low = mid + 1;

        } else {

            if (target > arr[mid])
                high = mid - 1;
            else
                low = mid + 1;

        }

    }

    return -1;
}
```

---

# Common Binary Search Interview Problems

- Binary Search
- Ceiling of a Number
- Floor of a Number
- First and Last Position of an Element
- Search Insert Position
- Search in Rotated Sorted Array
- Find Peak Element
- Peak Index in Mountain Array
- Count Occurrences
- Infinite Sorted Array
- Next Greatest Letter
- Square Root using Binary Search
- Koko Eating Bananas
- Capacity to Ship Packages Within D Days
- Median of Two Sorted Arrays

---

# Advantages

- Very fast searching.
- Efficient for large datasets.
- Requires very few comparisons.
- Uses Divide and Conquer.
- Time complexity is logarithmic.

---

# Limitations

- Array must be sorted.
- Not suitable for frequently changing data.
- Insertion and deletion remain expensive in arrays.

---

# Binary Search vs Linear Search

| Feature | Linear Search | Binary Search |
|----------|---------------|---------------|
| Data Requirement | Unsorted or Sorted | Sorted Only |
| Time Complexity | O(n) | O(log n) |
| Best Case | O(1) | O(1) |
| Worst Case | O(n) | O(log n) |
| Space Complexity | O(1) | O(1) (Iterative) |
| Approach | Sequential | Divide and Conquer |

---

# Common Mistakes

- Applying Binary Search to an unsorted array.
- Using `mid = (low + high) / 2`, which can overflow for very large indices.
- Forgetting to update `low` or `high`, leading to infinite loops.
- Incorrect loop condition (`low < high` instead of `low <= high` in many implementations).
- Not handling ascending and descending arrays correctly.

---

# Best Practices

- Ensure the array is sorted before performing Binary Search.
- Calculate the middle index safely:

```java
int mid = low + (high - low) / 2;
```

- Prefer the iterative version unless recursion is specifically required.
- Return `-1` when the target element is not found.
- Use Order-Agnostic Binary Search when the sort order is unknown.

---

# Summary

Binary Search is one of the most important searching algorithms in computer science. It repeatedly halves the search space, making it significantly faster than Linear Search for sorted data. With a time complexity of **O(log n)**, it is widely used in searching, optimization problems, competitive programming, and technical interviews. Mastering Binary Search and its variations is essential for solving many advanced algorithmic problems.
