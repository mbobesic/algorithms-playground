# link: https://codility.com/demo/take-sample-test/number_of_disc_intersections
# name: Number Of Disc Intersections


def solution(A):
    # write your code in Python 2.6
    if len(A)==0:
        return 0
    
    ups = [0]*len(A)
    downs = [0]*len(A)
    for index in xrange(0,len(A)):
        current = A[index]
        
        lower = max(index-current,0)
        upper = min(len(A)-1, index+current)
        
        ups[lower] +=1
        downs[upper] -= 1
    
   
    existing = [0] * (len(A)+1)
    existing[0] = ups[0]
    for index in xrange(1,len(A)):
        existing[index] = existing[index-1] + ups[index] + downs[index-1]
    
    result = 0
    
    for index in xrange(0, len(ups)):
        if ups[index] > 0:
            up = ups[index]
            diff = existing[index] - up
            result += up*(up-1)/2 + up*diff
            
    if result > 10000000:
        return -1
    
    return result

