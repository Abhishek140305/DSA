defmodule Solution do
    @spec get_row(row_index :: integer) :: [integer]
    def get_row(row_index) when row_index == 0, do: [1]
    def get_row(row_index), do: [1 | row_index - 1 |> get_row |> build_row]

    def build_row([head | []]), do: [1]
    def build_row([head | tail]), do: [head + hd(tail) | build_row(tail)]
end