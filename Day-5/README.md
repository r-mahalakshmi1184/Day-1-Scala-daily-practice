## Performance Notes

- `map`, `filter`, and `flatMap` are transformations and are evaluated lazily.
- `collect`, `count`, `first`, `take`, and `reduce` are actions.
- `distinct` requires a shuffle because duplicate values may exist in different partitions.
- `union` combines RDDs without removing duplicates.
- `collect` brings all data to the driver, so it should be avoided for very large datasets.
- Increasing the number of partitions can improve parallel processing, but too many partitions can add overhead.
- The log analyzer uses `filter` followed by actions such as `count` and `collect`.
