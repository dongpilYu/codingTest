PILAR, BEAM = 0,1

# x, y, 기둥: 0, 보: 1, 삭제: 0, 설치: 1

def solution(n, build_frame):
    for build in build_frame:
        x, y, boOrNot, install = build
        print(x, y, boOrNot, install)
        answer = set()
        if install:
            # 추가
            if boOrNot:
                # 보일 경우
                if check(x, y, boOrNot, answer):
                    answer.add((x, y, boOrNot))

            else:
                # 기둥일 경우
                if check(x, y, boOrNot, answer):
                    answer.add((x, y, boOrNot))

        else:
            # 삭제
            answer.remove((x, y, boOrNot))
            canDelete = True
            for item in answer:
                if check(item[0], item[1], item[2], answer):
                    # 뺀 후에 하나라도 존재할 수 없는게 생긴다면 삭제할 수 없다.
                    #
                    pass
                else:
                    canDelete = False
                    break
            if canDelete != True:
                answer.add((x, y, boOrNot))


    return answer.sort()


def check(x, y, boOrNot, answer):
    if boOrNot:
        if (x, y-1, 0) in answer:
            # 아래에 기둥이 있을 경우
            return True
        if (x+1, y, 1) in answer and (x-1, y, 1) in answer:
            # 보가 양 옆에 연결되어 있을 경우
            return True

    else:
        if y == 0:
            # 바닥에 있을 경
            return True
        if (x, y, 1) in answer or (x-1, y, 1) in answer:
            # 보 위에 있을 경우
            return True
        if (x, y-1, 0) in answer:
            # 기둥 위에 있을 경우
            return True


build_frame = [[1,0,0,1],[1,1,1,1],[2,1,0,1],[2,2,1,1],[5,0,0,1],[5,1,0,1],[4,2,1,1],[3,2,1,1]]
count = 5

answer = solution(count, build_frame)
print(answer)