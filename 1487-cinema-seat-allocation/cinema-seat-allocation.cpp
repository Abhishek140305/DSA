class Solution {
public:
    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {
        unordered_map<int, vector<int>> mp;
        int group = 0;
        int count = 0;

        for (auto seat : reservedSeats) {
            mp[seat[0]].push_back(seat[1]);
        }

        for (auto& row : mp) {
            bool groupA = true;
            bool groupB = true;
            bool groupC = true;

            count++;

            for (int seat : row.second) {
                if (seat == 2 || seat == 3 || seat == 4 || seat == 5)
                    groupA = false;

                if (seat == 4 || seat == 5 || seat == 6 || seat == 7)
                    groupB = false;

                if (seat == 6 || seat == 7 || seat == 8 || seat == 9)
                    groupC = false;
            }

            if (groupA && groupC)
                group += 2;
            else if (groupA || groupB || groupC)
                group++;
        }

        group += (n - count) * 2;

        return group;
    }
};