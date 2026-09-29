class MedianFinder {
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;

    public MedianFinder() {
        maxheap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        minheap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxheap.isEmpty() || num <= maxheap.peek()) {
            maxheap.offer(num);
        } else {
            minheap.offer(num);
        }

        if (maxheap.size() > minheap.size() + 1) {
            minheap.offer(maxheap.poll());
        } else if (maxheap.size() < minheap.size()) {
            maxheap.offer(minheap.poll());
        }
    }

    public double findMedian() {
        if (maxheap.size() == minheap.size()) {
            return maxheap.peek() / 2.0 + minheap.peek() / 2.0;
        }
            return maxheap.peek();
        }
    
}
