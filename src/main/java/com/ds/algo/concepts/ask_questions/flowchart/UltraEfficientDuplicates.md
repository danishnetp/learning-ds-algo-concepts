# UltraEfficientDuplicates Flowchart

```mermaid
flowchart TD
    A([Start: findDuplicates1\nInput: int[] nums]) --> B[Initialize empty\nList duplicates]
    B --> C{nums == null or\nnums.length < 2?}
    C -- Yes --> D[Return duplicates]
    D --> E([Stop])

    C -- No --> F[Sort input array\nArrays.sort(nums)]
    F --> G[Initialize loop:\ni = 1]
    G --> H{i < nums.length?}

    H -- No --> I[Return duplicates list]
    I --> J([Stop])

    H -- Yes --> K{nums[i] == nums[i - 1]?}
    K -- No --> N[Increment i]

    K -- Yes --> L{duplicates is empty\nor last != nums[i]?}
    L -- Yes --> M[Add nums[i] to\nduplicates list]
    M --> N
    L -- No --> N

    N --> H
```

