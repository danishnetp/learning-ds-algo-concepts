# ZeroSumSubarray Flowchart

```mermaid
flowchart TD
    A([Start]) --> B[Input array A]
    B --> C{A == null or\nA.length == 0?}

    C -- yes --> D["return empty array []"]
    D --> E([Stop])

    C -- no --> F[Initialize map = HashMap<Integer, Integer>]
    F --> G[currentSum = 0]
    G --> H[maxLength = 0]
    H --> I[startIdx = -1]
    I --> J[endIdx = -1]
    J --> K[i = 0]

    K --> L{i < A.length?}
    L -- no --> W{maxLength > 0?}

    L -- yes --> M["currentSum = currentSum + A[i]"]
    M --> N{currentSum == 0?}

    N -- yes --> O[maxLength = i + 1]
    O --> P[startIdx = 0]
    P --> Q[endIdx = i]
    Q --> V[i = i + 1]

    N -- no --> R{map contains currentSum?}
    R -- no --> S[map.put(currentSum, i)]
    S --> V

    R -- yes --> T[prevIdx = map.get(currentSum)]
    T --> U{(i - prevIdx) > maxLength?}
    U -- yes --> U1[maxLength = i - prevIdx]
    U1 --> U2[startIdx = prevIdx + 1]
    U2 --> U3[endIdx = i]
    U3 --> V
    U -- no --> V

    V --> L

    W -- yes --> X[return Arrays.copyOfRange(A, startIdx, endIdx + 1)]
    X --> Y([Stop])
    W -- no --> Z["return empty array []"]
    Z --> Y
```

