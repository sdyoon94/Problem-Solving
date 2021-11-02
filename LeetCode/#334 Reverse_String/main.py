import collections
import heapq
import functools
import itertools
import re
import sys
import math
import bisect
from typing import *

class Solution:
    def reverseString(self, s: List[str]) -> None:
        #투 포인터 이용
        # left, right = 0, len(s)-1
        # while left < right:
        #     s[left], s[right] = s[right], s[left]
        #     left += 1
        #     right -= 1

        #파이썬다운 방식
        s.reverse()