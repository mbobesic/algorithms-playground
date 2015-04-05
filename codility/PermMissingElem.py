# link: https://codility.com/demo/take-sample-test/perm_missing_elem
# name: Perm Missing Element

def solution(A):
    
    total = sum(A)
    max = len(A)+1
    expected = max*(max+1)/2
    return expected - total

