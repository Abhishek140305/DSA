defmodule Solution do
  @spec minimum_total(triangle :: [[integer]]) :: integer
  def minimum_total(triangle) do
    triangle
    |> Enum.reverse()
    |> Enum.reduce(fn row, acc ->
      acc
      |> Stream.chunk_every(2, 1, :discard)
      |> Stream.map(&apply(Kernel, :min, &1))
      |> Stream.zip_with(row, &+/2)
    end)
    |> Enum.at(0)
  end
end