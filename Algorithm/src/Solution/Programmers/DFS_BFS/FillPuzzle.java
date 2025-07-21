package Solution.Programmers.DFS_BFS;
// Lv.3 퍼즐 조각 채우기

import java.util.*;
public class FillPuzzle {
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    public int solution(int[][] game_board, int[][] table) {
        int n = game_board.length;
        boolean[][] visited = new boolean[n][n];

        // 1. 게임판에서 빈 공간 찾기
        List<List<int[]>> emptySpaces = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (game_board[i][j] == 0 && !visited[i][j]) {
                    List<int[]> space = new ArrayList<>();
                    dfs(game_board, visited, i, j, space, 0);

                    emptySpaces.add(normalize(space));
                }
            }
        }

        // 2. 테이블에서 퍼즐 조각 찾기
        visited = new boolean[n][n];
        List<List<int[]>> puzzlePieces = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (table[i][j] == 1 && !visited[i][j]) {
                    List<int[]> piece = new ArrayList<>();
                    dfs(table, visited, i, j, piece, 1);

                    puzzlePieces.add(normalize(piece));
                }
            }
        }

        // 3. 퍼즐 조각을 빈 공간에 맞춰보기
        boolean[] used = new boolean[puzzlePieces.size()];
        int cnt = 0;

        for (List<int[]> emptySpace : emptySpaces) {
            for (int i=0; i< puzzlePieces.size(); i++) {
                if (used[i]) {
                    continue;
                }

                List<int[]> puzzlePiece = puzzlePieces.get(i);
                if (canFit(emptySpace, puzzlePiece)) {
                    used[i] = true;
                    cnt += emptySpace.size();
                    break;
                }
            }
        }

        return cnt;
    }

    static void dfs(int[][] arr, boolean[][] visited, int x, int y, List<int[]> shape, int target) {
        visited[x][y] = true;
        shape.add(new int[] {x, y});

        for (int k=0; k<4; k++) {
            int nr = x + dr[k];
            int nc = y + dc[k];

            if (0 <= nr && nr < arr.length && 0 <= nc && nc < arr[0].length && !visited[nr][nc] && arr[nr][nc] == target) {
                dfs(arr, visited, nr, nc, shape, target);
            }
        }
    }

    // 좌표를 상대 좌표로 정규화 (가장 작은 좌표를 (0,0)으로)
    // 정규화 하는 이유는 같은 모양의 도형이라도 위치가 다르면 다른 도형으로 인식하기 때문에
    static List<int[]> normalize(List<int[]> shape) {
        if (shape.isEmpty()) {
            return shape;
        }

        int minX = shape.get(0)[0];
        int minY = shape.get(0)[1];

        for (int[] pos : shape) {
            minX = Math.min(minX, pos[0]);
            minY = Math.min(minY, pos[1]);
        }

        List<int[]> normalized = new ArrayList<>();
        for (int[] pos : shape) {
            normalized.add(new int[] {pos[0] - minX, pos[1] - minY});
        }

        // 서로 비교가 가능하도록 정렬
        normalized.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        return normalized;
    }

    // 빈 공간과 퍼즐 조각이 맞는지 확인 (4가지 회전 모두)
    static boolean canFit(List<int[]> emptySpace, List<int[]> puzzlePiece) {
        if (emptySpace.size() != puzzlePiece.size()) {
            return false;
        }

        List<int[]> piece = new ArrayList<>();
        for (int[] pos : puzzlePiece) {
            piece.add(new int[] {pos[0], pos[1]});
        }

        // 4방향 회전 모두 확인
        for (int i=0; i<4; i++) {
            if (isSameShape(emptySpace, piece)) {
                return true;
            }
            piece = rotate(piece);
        }

        return false;
    }

    // 90도 회전
    static List<int[]> rotate(List<int[]> shape) {
        List<int[]> rotated = new ArrayList<>();

        for (int[] pos : shape) {
            // (x, y) -> (y, -x) 회전
            rotated.add(new int[] {pos[1], -pos[0]});
        }

        // 90도 회전 후 다시 정규화
        return normalize(rotated);
    }

    static boolean isSameShape(List<int[]> shape1, List<int[]> shape2) {
        if (shape1.size() != shape2.size()) {
            return false;
        }

        for (int i=0; i<shape1.size(); i++) {
            int[] pos1 = shape1.get(i);
            int[] pos2 = shape2.get(i);

            if (pos1[0] != pos2[0] || pos1[1] != pos2[1]) {
                return false;
            }
        }

        return true;
    }
}
