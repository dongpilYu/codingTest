def solution(m, n, board):
    answer = 0
    finish = True

    board_ = []
    for i in range(len(question)):
        board_.append(list(question[i]))

    print(board_)
    while finish:
        block = 0
        # 4칸이 같은 지 확인
        for i in range(len(board_)-1):
            for j in range(len(board_[i])-1):

                if board_[i][j] == '0':
                    continue
                    # 공백일 경우 그냥 넘어감

                if board_[i][j].lower() == board_[i+1][j].lower() \
                        and board_[i][j].lower() == board_[i][j+1].lower() \
                        and board_[i][j].lower() == board_[i+1][j+1].lower():
                    # 소문자던, 아니던 같은 모양이면 일단 체

                    block += 1

                    if board_[i][j].isupper():
                        board_[i][j] = board_[i][j].lower()
                        answer += 1

                    if board_[i][j+1].isupper():
                        board_[i][j+1] = board_[i][j+1].lower()
                        answer += 1

                    if board_[i+1][j].isupper():
                        board_[i+1][j] = board_[i+1][j].lower()
                        answer += 1

                    if board_[i+1][j+1].isupper():
                        board_[i+1][j+1] = board_[i+1][j+1].lower()
                        answer += 1

                if block == 0:
                    finish = False
                    break
        print(board_)
        # 4칸짜리 공백으로 만들기

        for i in range(len(board_)):
            idx = 0
            first = True
            for j in range(len(board_[i])):
                if board_[i][j].isupper() and first:
                    idx = j
                    first = False
                #

                if board_[i][j].islower():
                    board_[i][j] = '0'
                    for k in range(j-idx):
                        board_[i][j] = board_[i][j-k-1]
                        board_[i][j-k-1] = '0'
        print(board_)
        break
    return answer

question = ["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]
solution(6,6,question)
