package file;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class FilesShould {
    @Test
    void compare_files() throws URISyntaxException, IOException {
        Path path_file_1 = Path.of(Objects.requireNonNull(getClass().getClassLoader().getResource("file1.txt")).toURI());
        Path path_file_2 = Path.of(Objects.requireNonNull(getClass().getClassLoader().getResource("file2.txt")).toURI());
        Path path_file_3 = Path.of(Objects.requireNonNull(getClass().getClassLoader().getResource("file3.txt")).toURI());

        Assertions.assertThat(Files.mismatch(path_file_1, path_file_2)).isEqualTo(-1);
        Assertions.assertThat(Files.mismatch(path_file_1, path_file_3)).isEqualTo(5);

    }
}
