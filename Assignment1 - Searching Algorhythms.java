// write java code for all searching algorhythms
// 1. Linear search
// 2. Binary search
// 3. Jump search
// 4. Interpolation search
// 5. Exponential search




import java.util.Scanner;

public class LinearSearch {
    static int search(int arr[], int x) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            if(arr[i] == x)
                return i;
        }
        return -1;
    }
}

public class BinarySearch {
    int binarySearch(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x)
                return m;
            if (arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }
}
public class InterpolationSearch {
    int interpolationSearch(int arr[], int x) {
        int lo = 0, hi = (arr.length - 1);
        while (lo <= hi && x >= arr[lo] && x <= arr[hi]) {
            if (lo == hi) {
                if (arr[lo] == x) return lo;
                return -1;
            }
            int pos = lo + (((hi - lo) / (arr[hi] - arr[lo])) * (x - arr[lo]));
            if (arr[pos] == x)
                return pos;
            if (arr[pos] < x)
                lo = pos + 1;
            else
                hi = pos - 1;
        }
        return -1;
    }
}

public class JumpSearch {
    public static int jumpSearch(int[] arr, int x) {
        int n = arr.length;
        int step = (int)Math.floor(Math.sqrt(n));
        int prev = 0;
        while (arr[Math.min(step, n)-1] < x) {
            prev = step;
            step += (int)Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }
        while (arr[prev] < x) {
            prev++;
            if (prev == Math.min(step, n))
                return -1;
        }
        if (arr[prev] == x)
            return prev;
        return -1;
    }
}

public class ExponentialSearch {
    int exponentialSearch(int arr[], int n, int x) {
        if (arr[0] == x)
            return 0;
        int i = 1;
        while (i < n && arr[i] <= x)
            i = i*2;
        return Arrays.binarySearch(arr, i/2, Math.min(i, n), x);
    }
}
